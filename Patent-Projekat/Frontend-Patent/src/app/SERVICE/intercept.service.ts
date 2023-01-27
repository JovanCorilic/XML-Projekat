import { Observable } from 'rxjs';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from '@angular/core';

@Injectable()
export class Interceptor implements HttpInterceptor{
    intercept(req:HttpRequest<any>, next:HttpHandler):Observable<HttpEvent<any>>{
        const item = localStorage.getItem('accessToken');

        if (item) {
			const cloned = req.clone({
				headers: req.headers.set('Authorization','Bearer '+item)
			});

			return next.handle(cloned);
		} else {
			return next.handle(req);
		}
    }
}