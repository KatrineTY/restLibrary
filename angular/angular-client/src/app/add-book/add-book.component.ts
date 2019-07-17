import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Book } from '../book';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book: Book = new Book();
  submitted = false;

  constructor(private bookService: BookService,
    private router: Router) { }

  ngOnInit() {
  }

  newBook(): void {
    this.submitted = false;
    this.book = new Book();
  }

  save() {
    this.bookService.addBook(this.book)
      .subscribe(data => console.log(data), error => console.log(error));
    this.book = new Book();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/books']);
  }

}
