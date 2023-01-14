import { SearchService } from './../../services/search.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Doc } from 'src/app/model/search';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-table',
  templateUrl: './form-table.component.html',
  styleUrls: ['./form-table.component.scss']
})
export class FormTableComponent implements OnInit {

  reportForm = new FormGroup({
    start: new FormControl(''),
    end: new FormControl('')
  });

  textForm = new FormGroup({
    text: new FormControl(''),
  });

  metadataForm = new FormGroup({
    status: new FormControl(''),
    statusnot:new FormControl(''),
    username: new FormControl(''),
    usernamenot: new FormControl(''),
    typa: new FormControl(''),
    typenot: new FormControl(''),
    datestart: new FormControl(''),
    dateend: new FormControl(''),
    datenot: new FormControl(''),
    firstop: new FormControl(''),
    secondop: new FormControl(''),
    thirdop: new FormControl(''),
  });

  teble_data: Doc[] = [] ;

  columns: Array<keyof Doc> = ['documentid', 'documenttype', 'status'];

  my_role:string = '';

  trademark_types: any = ['IndividualTrademark', 'CollectiveTrademark', 'GuaranteeTrademark'];


  constructor(private searchService: SearchService,private router: Router) {
    this.roleSearch()
  }

  ngOnInit(): void {
  }

  public generateHTML(i:number):void{

    if(this.teble_data[i].documenttype === 'SOLUTION'){
      this.searchService.generateSolutionHTML(this.teble_data[i].documentid);
    }else{
      this.searchService.generateHTML(this.teble_data[i].documentid);
    }

  }
  public generatePDF(i:number):void{

    if(this.teble_data[i].documenttype === 'SOLUTION'){
      this.searchService.generateSolutionPDF(this.teble_data[i].documentid);
    }else{
      this.searchService.generatePDF(this.teble_data[i].documentid);
    }

  }
  public generateRDF(i:number):void{

    this.searchService.generateRDF(this.teble_data[i].documentid);

  }
  public generateJSON(i:number):void{

    this.searchService.generateJSON(this.teble_data[i].documentid);
  }

  public generateReportPDF():void{

    this.searchService.generateReportPDF(this.reportForm.value.start, this.reportForm.value.end);

  }

  public viewSolution(i:number):void{

    let url = '/' + 'solution' + '/' + this.teble_data[i].documentid;
    this.router.navigate([url]);
  }



  // Choose city using select dropdown
  changeCity(e:any) {
    console.log(e.value)
    if(this.trademarkType != null){
      this.trademarkType.setValue(e.target.value, {
        onlySelf: true
      })
    }

  }

  get trademarkType() {
    return this.metadataForm.get('typa');
  }


  public roleSearch():void{
    let token = localStorage.getItem('user_token');
    if(token){
      this.my_role = JSON.parse(atob(token.split('.')[1]))['roles'].split(',');
      if(this.my_role.includes('CITIZEN')){
        let txt = ` <metadata>
                      <status>WAIT</status>
                      <statusnot>false</statusnot>
                      <role></role>
                      <usrname>apaci</usrname>
                      <usernamenot>false</usernamenot>
                      <typa></typa>
                      <typenot>false</typenot>
                      <datestart>0</datestart>
                      <dateend>0</dateend>
                      <datenot>false</datenot>
                      <firstop>false</firstop>
                      <secondop>false</secondop>
                      <thirdop>false</thirdop>
                    </metadata>`;

        this.searchService.metadataSearch(txt).subscribe((data:Doc[]) => {
          this.teble_data = data;
        })
      }
      else{
        this.searchService.textSearch(this.my_role[0],'a').subscribe((data:Doc[]) => {
          this.teble_data = data;
          console.log(this.teble_data);
        })
      }
    }

  }

  public textSearch():void{
    console.log(this.my_role[0]);
    this.searchService.textSearch(this.my_role[0],this.textForm.value.text).subscribe((data:Doc[]) => {
      this.teble_data = data;
    })
  }

  public metadataSearch():void{
    console.log(this.metadataForm.value);
    console.log(+this.metadataForm.value.datestart);
    let txt = '<metadata>';
    txt += '<status>' + this.metadataForm.value.status + '</status>';
    txt += '<statusnot>' + this.metadataForm.value.statusnot + '</statusnot>';
    txt += '<role>' + this.my_role + '</role>';
    txt += '<usrname>' + this.metadataForm.value.username + '</usrname>';
    txt += '<usernamenot>' + this.metadataForm.value.usernamenot + '</usernamenot>';
    txt += '<typa>' + this.metadataForm.value.typa + '</typa>';
    txt += '<typenot>' + this.metadataForm.value.typenot + '</typenot>';
    txt += '<datestart>' + +this.metadataForm.value.datestart + '</datestart>';
    txt += '<dateend>' + +this.metadataForm.value.dateend + '</dateend>';
    txt += '<datenot>' + this.metadataForm.value.datenot + '</datenot>';
    txt += '<firstop>' + this.metadataForm.value.firstop + '</firstop>';
    txt += '<secondop>' + this.metadataForm.value.secondop + '</secondop>';
    txt += '<thirdop>' + this.metadataForm.value.thirdop + '</thirdop>';
    txt += '</metadata>';

    console.log(txt);
    this.searchService.metadataSearch(txt).subscribe((data:Doc[]) => {
      this.teble_data = data;
    })
  }

}
