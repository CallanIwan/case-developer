import { Component } from '@angular/core';
import {Employee, PensionService} from "../pension.service";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-pension',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: './pension.component.html',
  styleUrl: './pension.component.css'
})
export class PensionComponent {
  employee: Employee | null = null;
  error: string | null = null;

  constructor(private pensionService: PensionService) {}

  ngOnInit(): void {
    this.pensionService.getAllEmployees().subscribe({
      next: (data) => this.employee = data,
      error: (err) => this.error = err.message
    });
  }
}
