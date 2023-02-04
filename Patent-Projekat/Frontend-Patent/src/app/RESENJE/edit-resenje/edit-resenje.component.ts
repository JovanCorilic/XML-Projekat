import { PatentService } from './../../SERVICE/patent.service';
import { ResenjeService } from './../../SERVICE/resenje.service';
import { XonomyResenjeCreateService } from './../../SERVICE/xonomyResenjeCreateService.service';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Konverzija } from 'src/app/SERVICE/konverzija.service';

declare const Xonomy:any;

@Component({
  selector: 'app-edit-resenje',
  templateUrl: './edit-resenje.component.html',
  styleUrls: ['./edit-resenje.component.css']
})
export class EditResenjeComponent {
  patentId=<string>{}
  temp:string|null;
  mapa:Map<string,string>;
  listaResenja:string[]|undefined;

  constructor(
    private resenjeService:ResenjeService,
    private patentService:PatentService,
    private router:Router,
    private route:ActivatedRoute,
    private xonomyResenjeEdit:XonomyResenjeCreateService
  ) {
    this.temp=this.route.snapshot.paramMap.get('resenje');
      if(this.temp != null)
        this.patentId = this.temp;
      else
        this.patentId = "nista";
    this.mapa = new Map();
   }

  ngOnInit(): void {
  
  this.resenjeService.getResenje(this.patentId).subscribe(
    res=>{
      let element = document.getElementById("editor");
      let specification = this.xonomyResenjeEdit.resenjeSpecification;
      let xmlString = res;
      Xonomy.setMode("laic");
      Xonomy.render(xmlString, element, specification);
      
      Xonomy.refresh();
    }
  )

  this.resenjeService.getReferencuNaZahtev(this.patentId).subscribe(
    res=>{
      this.listaResenja = Konverzija.uzimanjePodatakaXMLDtoLista(res);
        this.listaResenja.forEach(element => {
          this.prikazOznakaPatenta(element,this.mapa);
        });
    }
  )
}

send(){
  let text = Xonomy.harvest();
  
  text = '<?xml version="1.0" encoding="UTF-8"?>'+ text;
  
  this.resenjeService.editResenje(text).subscribe(
    res=>{
      this.router.navigate(['/svaResenja']);
    },
    error=>{
      alert("Podaci nisu pravilni")
    }
  )
}

natrag(){
  this.router.navigate(['/svaResenja']);
}

idiNaEditResenje(resenje:string){
 
  this.router.navigate(['/edit-patent/'+resenje+'/true']);
}

prikazOznakaPatenta(id:string,Mapa:Map<string,string>){
  this.patentService.getOznakePatenta(id).subscribe(
    res=>{
      Mapa.set(id,Konverzija.uzimanjePodatakaXMLDto(res));
    }
  );

}

}
