import { Component, OnInit } from '@angular/core';
import { DownloadServiceService } from 'src/app/download-service.service';
import { FileData } from 'src/model/FileData';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-files',
  templateUrl: './files.component.html'
})
export class FilesComponent implements OnInit {

  fileList?: FileData[];

  constructor(private downloadService: DownloadServiceService) {
  }

  ngOnInit(): void {
    this.getFileList();
  }

  getFileList(): void {
    this.downloadService.list().subscribe(result => {
      this.fileList = result;
    });
  }

  downloadFile(fileData: FileData): void {
    this.downloadService
      .download(fileData.filename)
      .subscribe(blob => saveAs(blob, fileData.filename));
  }
}