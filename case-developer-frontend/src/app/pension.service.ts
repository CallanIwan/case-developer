import {Injectable} from "@angular/core";
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

export interface Employee {
  id: string;
  name: string;
  position: string;
  department: string;
}

@Injectable({
  providedIn: 'root'
})
export class PensionService {

  private readonly apiUrl = 'http://localhost:8080/pension/employees';

  constructor(private http: HttpClient) {}

  getAllEmployees(): Observable<Employee> {
    return this.http.get<Employee>(this.apiUrl).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.error instanceof ErrorEvent) {
      // Client-side or network error
      console.error('An error occurred:', error.error.message);
    } else {
      // Backend error
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(() => new Error('Something went wrong; please try again later.'));
  }
}
