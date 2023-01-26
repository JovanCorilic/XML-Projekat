import { AfterViewInit, Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { TrademarkService } from 'src/app/services/trademark.service';

declare const Xonomy: any;
declare const MyObj: any;

@Component({
  selector: 'app-trademark-form',
  templateUrl: './trademark-form.component.html',
  styleUrls: ['./trademark-form.component.scss']
})
export class TrademarkFormComponent implements OnInit, AfterViewInit {

  file: any= null; // Variable to store file
  file_logo: any= null; // Variable to store file
  list_files: any[] = [];
  base64textString:string[] = [];
  image_paths :any[] = [];
  logo:any ;
  logo_img:string = '';
  constructor(private trademark_service: TrademarkService, private _sanitizer :DomSanitizer ) { }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    let trademark_form = document.getElementById("trademark-form");
    let spec = this.trademark_service.trademark_specification;
    Xonomy.render('<trademark> </trademark>', trademark_form, spec);

  }

  send() {
    let text = Xonomy.harvest();

    // const entity = text;
    // console.log(text);
    // console.log(text);
    let username = localStorage.getItem('user_token');
    if(username != null) {
      username = JSON.parse(atob(username.split('.')[1]))['sub'];
    }
    // console.log('USRNM'+username);
    // console.log(text.split("</trademark>")[0]);
    let document_text = text.split("</trademark>")[0].trim();
    document_text += '<username>' + username + '</username>';
    document_text += '</trademark>';
    text = document_text;
    if(this.list_files.length>0){

      let document_text = text.split("</trademark>")[0].trim();
      document_text += '<documents>';

      for (let elem of this.list_files){
        // console.log(elem);
        document_text+= '<document>' + elem + '</document>';
      }

      document_text +='</documents></trademark>';
      text = document_text;
    }

    if (text.includes("trademark_info") && this.logo_img!= ''){
      let document_text0 = text.split("<trademark_info>")[0].trim();
      document_text0 += '<trademark_info><trademark_view>' + this.logo_img + '</trademark_view>';
      let document_text1 = text.split("<trademark_info>")[1].trim();
      document_text0+= document_text1;
      text = document_text0;
    }
    if(text.includes("trademark_info") == false && this.logo_img!= ''){
      let document_text0 = text.split("</trademark>")[0].trim();
      document_text0 += '<trademark_info><trademark_view>' + this.logo_img + '</trademark_view></trademark_info>';
      document_text0 += '</trademark>';
      text = document_text0
    }

    console.log(text);
    this.trademark_service.sendXml(text).subscribe(
      response=>{
        console.log(response);
      }
    );
  }
  onChange(event:any) {
    this.file = event.target.files[0];
  }

  onChangeLogo(event:any) {
    this.file_logo = event.target.files[0];
  }

  onUpload(){
    // this.loading = !this.loading;
    // console.log(this.file);


    if (this.file) {
      const reader = new FileReader();

      reader.onload = this.handleReaderLoaded.bind(this);
      reader.readAsBinaryString(this.file);
    }
  }

  onLogo(){
    // this.loading = !this.loading;
    // console.log(this.file);


    if (this.file_logo) {
      const reader = new FileReader();

      reader.onload = this.handleReaderLogo.bind(this);
      reader.readAsBinaryString(this.file_logo);
    }
  }

  handleReaderLogo(e:any) {
    let img = 'data:image/png;base64,' + btoa(e.target.result);
    // this.base64textString.push(img);
    // console.log("this.base64textString");
    // console.log(this.base64textString);

    // if(!this.list_files.includes(btoa(e.target.result))){
    //   this.list_files = [...this.list_files,btoa(e.target.result)];
    //   // console.log(this.list_files);
    // }
    this.logo_img = img;
    this.logo = this._sanitizer.bypassSecurityTrustResourceUrl(img);
    // console.log(this.logo);
  }

  handleReaderLoaded(e:any) {
    let img = 'data:image/png;base64,' + btoa(e.target.result);
    // this.base64textString.push(img);
    // console.log("this.base64textString");
    // console.log(this.base64textString);

    if(!this.list_files.includes(btoa(e.target.result))){
      this.list_files = [...this.list_files,btoa(e.target.result)];
      // console.log(this.list_files);
    }

    this.image_paths =[...this.image_paths, this._sanitizer.bypassSecurityTrustResourceUrl(img)];
    // console.log(this.image_paths);
    // this.base64textString = [];
  }

}
