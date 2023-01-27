import { Konverzija } from './../../SERVICE/konverzija.service';
import { XonomyPatentEditService } from './../../SERVICE/xonomyPatentEdit.service';
import { PatentService } from './../../SERVICE/patent.service';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

declare const Xonomy:any;
@Component({
  selector: 'app-edit-patent',
  templateUrl: './edit-patent.component.html',
  styleUrls: ['./edit-patent.component.css']
})
export class EditPatentComponent {
  patentId=<string>{}
  temp:string|null;
  prodjeno:string|null;

  constructor(
    private patentService:PatentService,
    private router:Router,
    private route:ActivatedRoute,
    private xonomyPatentEditService:XonomyPatentEditService
  ) {
    this.temp=this.route.snapshot.paramMap.get('patent');
      if(this.temp != null)
        this.patentId = this.temp;
      else
        this.patentId = "nista";
    this.prodjeno=this.route.snapshot.paramMap.get('prodjeno');
   }

  ngOnInit(): void {
    this.patentService.getPatent(this.patentId).subscribe(
      res=>{
        let element = document.getElementById("editor");
        let specification = this.xonomyPatentEditService.PatentSpecification;
        let xmlString = res;
        Xonomy.setMode("laic");
        Xonomy.render(xmlString, element, specification);
        
        Xonomy.refresh();
      }
    )
  }

  downloadRDF(){
    this.patentService.downloadRDF(this.patentId).subscribe(
      res=>{
        this.patentService.getOznakePatenta(this.patentId).subscribe(
          res2=>{
            this.previewAndDownload(Konverzija.uzimanjePodatakaXMLDto(res),Konverzija.uzimanjePodatakaXMLDto(res2),'rdf');
          }
        )
        
      }
    )
  }

  downloadHTML(){
    this.patentService.downloadHTML(this.patentId).subscribe(
      res=>{
        this.patentService.getOznakePatenta(this.patentId).subscribe(
          res2=>{
            this.previewAndDownload(Konverzija.uzimanjePodatakaXMLDto(res),Konverzija.uzimanjePodatakaXMLDto(res2),'html');
          }
        )
        
      }
    )
  }

  downloadPDF(){
    this.patentService.downloadPDF(this.patentId);/*.subscribe(
      res=>{
        let url = window.URL.createObjectURL(res);
        var link = document.createElement('a');
        link.href = url;
        link.download = "patent-";
        link.click();
      }
    )*/
  }

  downloadJSON(){
    this.patentService.downloadJSON(this.patentId).subscribe(
      res=>{
        this.patentService.getOznakePatenta(this.patentId).subscribe(
          res2=>{
            this.previewAndDownload(Konverzija.uzimanjePodatakaXMLDto(res),Konverzija.uzimanjePodatakaXMLDto(res2),'json');
          }
        )
        
      }
    )
  }

  previewAndDownload(response: any, id: string, tip: string){
    let type = "application/"+tip;
    let blob = new Blob([response], { type: type});
    let url = window.URL.createObjectURL(blob);
    var link = document.createElement('a');
    link.href = url;
    link.download = "patent-"+id+"."+tip;
    link.click();
  }

  send(){
    let text = Xonomy.harvest();
    
    text = '<?xml version="1.0" encoding="UTF-8"?>'+
    ' <?xml-stylesheet type="text/xsl" href="src/main/resources/xslt/P-1.xsl"?> '+ text;
    
    this.patentService.editXml(text).subscribe(
      res=>{
        this.router.navigate(['/svi-patent-neprodjeni/'+this.prodjeno]);
      }
    )
  }

  natrag(){
    this.router.navigate(['/svi-patent-neprodjeni/'+this.prodjeno]);
  }
}
