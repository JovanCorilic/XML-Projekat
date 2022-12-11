import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Zig } from '../model/Zig';

declare const Xonomy: any;

@Injectable({
  providedIn: 'root'
})
export class ZigService {

  private path = "http://localhost:8080/zig/save"



  constructor(private http: HttpClient) { }

  sendXml(entity: Zig) {
    return this.http.post(this.path, entity);
  }

  zig_specification = {
    elements: {
      "in:interesovanje": {
        menu: [{

          caption: 'Add <in:drzavljanin>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:drzavljanin xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:drzavljanin>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:drzavljanin")
          }
        },
        {

          caption: 'Add <in:jmbg>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:jmbg xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:jmbg>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:jmbg")
          }
        },
        {

          caption: 'Add <in:ime>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:ime xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:ime>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:ime")
          }
        }
          , {

          caption: 'Add <in:prezime>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:prezime xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:prezime>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:prezime")
          }
        },
        {

          caption: 'Add <in:mail>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:mail xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:mail>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:mail")
          }
        },
        {

          caption: 'Add <in:mobilni>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:mobilni xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:mobilni>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:mobilni")
          }
        },
        {

          caption: 'Add <in:fiksni>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:fiksni xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:fiksni>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:fiksni")
          }
        }
          ,
        {

          caption: 'Add <in:lokacija>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:lokacija xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:lokacija>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:lokacija")
          }
        }
          ,
        {

          caption: 'Add <in:tipVakcina>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:tipVakcina xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:tipVakcina>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:tipVakcina")
          }
        }
          ,
        {

          caption: 'Add <in:davalac>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:davalac xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:davalac>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:davalac")
          }
        }
          ,
        {

          caption: 'Add <in:datum>',
          action: Xonomy.newElementChild,
          actionParameter: '<in:datum xmlns:in="http://ftn.uns.ac.rs/interesovanje"> </in:datum>',
          hideIf: function (jsElement: any) {
            return jsElement.hasChildElement("in:datum")
          }
        }
        ],


        attributes: {}
      },
      "in:drzavljanin": {


        asker: Xonomy.askPicklist,
        askerParameter: ["drzavljaninSrbije", "straniDrzavljaninSaPrebivalistem", "straniDrzavljaninBezBoravka"]
      },
      "in:jmbg": {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString
      },
      "in:ime": {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString
      },
      "in:prezime": {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString
      },
      "in:mail": {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString
      },
      "in:mobilni": {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString
      },
      "in:fiksni": {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString
      },
      "in:lokacija": {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString
      },
      "in:tipVakcina": {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askPicklist,
        askerParameter: [
          { value: "moderna" },
          { value: "pfizerBioNTech" },
          { value: "astraZenecaOxford" },
          { value: "sputnikV" },
          { value: "sinopharm" },
          { value: "all" }
        ]
      },

      "in:davalac": {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askPicklist,
        askerParameter: [
          { value: "da" },
          { value: "ne" }
        ]

      },
      "in:datum": {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString
      }

    }
  }



}
