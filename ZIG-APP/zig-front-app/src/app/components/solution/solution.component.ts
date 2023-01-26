import { AfterViewInit, Component, OnInit } from "@angular/core";
import { DomSanitizer } from "@angular/platform-browser";
import { SolutionService } from "src/app/services/solution.service";
import { MyDocument } from "src/app/model/document";

declare const Xonomy: any;

@Component({
  selector: 'app-solution',
  templateUrl: './solution.component.html',
  styleUrls: ['./solution.component.scss']
})
export class SolutionComponent implements OnInit ,AfterViewInit{

  dokuments: any[]|undefined;

  list_files: any[] = [];

  uuid:string = "";

  constructor(private solutionService :SolutionService,private _sanitizer :DomSanitizer) { }

  ngOnInit(): void {
    this.getDocument();
  }

  ngAfterViewInit() {
    let trademark_form = document.getElementById("solution-form");
    let spec = this.solutionService.solution_specification;
    Xonomy.render('<solution> </solution>', trademark_form, spec);

  }

  getDocument(){
    var path = window.location.href;
    this.uuid = path.split("/")[path.split("/").length - 1];

    this.solutionService.getAllImages(this.uuid).subscribe((res:MyDocument[]) => {
      this.dokuments = res;

      // console.log(res);
      this.viewImage();
    });

  }

  public viewImage(){
    console.log(this.dokuments);
    if(this.dokuments!= undefined){
      for(let doc of this.dokuments){
        this.list_files =[...this.list_files, 'data:image/png;base64,' + doc];
        // console.log(this.list_files)
      }
    }


  }

  public accept(){

    let solution = Xonomy.harvest();
    let document_text = solution.split("<solution>")[1].trim();


    let username = localStorage.getItem('user_token');
    if(username != null) {
      username = JSON.parse(atob(username.split('.')[1]))['sub'];
    }

    var path = window.location.href;
    this.uuid = path.split("/")[path.split("/").length - 1];

    let text = '';

    text += '<solution>';
    text += '<username>' + username + '</username>';
    text += '<trademark_id>' + this.uuid + '</trademark_id>';
    text +='<status>ACCEPT</status>';
    text += document_text;
    console.log(text);
    this.solutionService.save(text).subscribe((res:Boolean) => {
      window.alert("ACCEPT")
    });
  }

  public decline(){
    let solution = Xonomy.harvest();
    let document_text = solution.split("<solution>")[1].trim();


    let username = localStorage.getItem('user_token');
    if(username != null) {
      username = JSON.parse(atob(username.split('.')[1]))['sub'];
    }

    var path = window.location.href;
    this.uuid = path.split("/")[path.split("/").length - 1];

    let text = '';

    text += '<solution>';
    text += '<username>' + username + '</username>';
    text += '<trademark_id>' + this.uuid + '</trademark_id>';
    text +='<status>DECLINE</status>';
    text += document_text;
    console.log(text);
    this.solutionService.save(text).subscribe((res:Boolean) => {
      window.alert("DCLINE")
    });
  }

}
