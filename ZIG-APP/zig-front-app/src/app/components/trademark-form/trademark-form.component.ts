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
  list_files: any[] = [];
  base64textString:string[] = [];
  image_path :any;

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
    console.log(text);
    // console.log(text.split("</trademark>")[0]);
    let document_text = text.split("</trademark>")[0].trim();
    document_text += '<documents>';

    for (let elem of this.list_files){
      // console.log(elem);
      document_text+= '<document>' + elem + '</document>';
    }

    document_text +='</documents></trademark>'
    console.log(document_text);
    this.trademark_service.sendXml(document_text).subscribe(
      response=>{
        console.log(response);
      }
    );
  }
  onChange(event:any) {
    this.file = event.target.files[0];
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

  handleReaderLoaded(e:any) {
    let img = 'data:image/png;base64,' + btoa(e.target.result);
    this.base64textString.push(img);
    // console.log("this.base64textString");
    // console.log(this.base64textString);

    if(!this.list_files.includes(btoa(e.target.result))){
      this.list_files = [...this.list_files,btoa(e.target.result)];
      // console.log(this.list_files);
    }

    this.image_path = this._sanitizer.bypassSecurityTrustResourceUrl(img);
    this.base64textString = [];
  }

}
