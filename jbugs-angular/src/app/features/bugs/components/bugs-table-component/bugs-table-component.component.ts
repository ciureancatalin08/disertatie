import {Component, OnInit, ViewChild} from '@angular/core';
import {Bug, BugJSON} from "../../models/bugs.model";
import {BugsService} from "../../services/bugs.service";
import {Observable} from "rxjs";
import {MatPaginator, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-bugs-table-component',
  templateUrl: './bugs-table-component.component.html',
  styleUrls: ['./bugs-table-component.component.css']
})
export class BugsTableComponentComponent implements OnInit {
  displayedColumns: string[] = ["title", "description", "version", "targetDate", "status", "fixedVersion", "severity"];
  // dataSource: Bug[] = [
  //   {title: "bug1",
  //     description: "description1",
  //     version: "v1.1",
  //     targetDate: "30-05-2019",
  //     status: "status",
  //     fixedVersion: "v7.2",
  //     severity: "sev"}
  //   ];

  data: Observable<Bug[]> = this.loadAllBugs();
  dataSource = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  private loadAllBugs(){
    return this.bugService.loadAllBugs();
  }
  constructor(private bugService: BugsService) { }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
  }

}



