import { xml2js } from "xml-js";

export class Konverzija{
    static uzimanjePodatakaXMLDtoLista(text: string):string[]{
        const object = xml2js(text);
        let duzina = object.elements[0].elements.length;
        let lista = [duzina];
        for(let i = 0;i<duzina;i++){
            lista[i] = object.elements[0].elements[i].elements[0].text;
        }
        return lista;
    }

    static uzimanjePodatakaXMLDto(text:string):string{
        const object = xml2js(text);
        let temp = object.elements[0].elements[0].elements[0].text;
        return temp;
    }
}