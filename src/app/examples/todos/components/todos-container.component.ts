import { Component, OnDestroy, OnInit } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { select, Store } from "@ngrx/store";
import { Subject } from "rxjs";
import { takeUntil } from "rxjs/operators";

import { ROUTE_ANIMATIONS_ELEMENTS } from "@app/core";

import {
  ActionTodosAdd,
  ActionTodosFilter,
  ActionTodosPersist,
  ActionTodosRemoveDone,
  ActionTodosToggle
} from "../todos.actions";
import { selectTodos } from "../todos.selectors";
import { Todo, TodosFilter, TodosState } from "../todos.model";
import { State } from "../../examples.state";
import { TranslateService } from "@ngx-translate/core";

@Component({
  selector: "anms-todos",
  templateUrl: "./todos-container.component.html",
  styleUrls: ["./todos-container.component.scss"]
})
export class TodosContainerComponent implements OnInit, OnDestroy {
  apiHave;
  apiHad;
  apiWant;
  apiSearch;

  //Get-------------------------------------------------
  getSearch() {
    const url = "http://localhost:8080/search";
    fetch(url)
      .then(resp => resp.json())
      .then(resp => (this.apiSearch = resp));
  }

  //Post-------------------------------------------------
  postWant(data) {
    const url = "http://localhost:8080/want";
    alert("You have added a game to your want library");
    const options = {
      method: "Post",
      body: JSON.stringify(data),
      headers: {
        "Content-Type": "application/json"
      }
    };
    fetch(url, options)
      .then(resp => resp.json())
      .then(resp => console.log(resp));
  }

  postHad(data) {
    const url = "http://localhost:8080/had";
    alert("You have added a game to your had library");
    const options = {
      method: "Post",
      body: JSON.stringify(data),
      headers: {
        "Content-Type": "application/json"
      }
    };
    fetch(url, options)
      .then(resp => resp.json())
      .then(resp => console.log(resp));
  }

  postHave(data) {
    const url = "http://localhost:8080/have";
    alert("You have added a game to your have library");
    const options = {
      method: "Post",
      body: JSON.stringify(data),
      headers: {
        "Content-Type": "application/json"
      }
    };
    fetch(url, options)
      .then(resp => resp.json())
      .then(resp => console.log(resp));
  }

  private unsubscribe$: Subject<void> = new Subject<void>();

  routeAnimationsElements = ROUTE_ANIMATIONS_ELEMENTS;
  todos: TodosState;
  newTodo = "";

  constructor(
    public store: Store<State>,
    public snackBar: MatSnackBar,
    public translateService: TranslateService
  ) {}

  ngOnInit() {
    this.store
      .pipe(
        select(selectTodos),
        takeUntil(this.unsubscribe$)
      )
      .subscribe(todos => {
        this.todos = todos;
        this.store.dispatch(new ActionTodosPersist({ todos }));
      });
  }

  ngOnDestroy(): void {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  get filteredTodos() {
    const filter = this.todos.filter;
    if (filter === "ALL") {
      return this.todos.items;
    } else {
      const predicate = filter === "DONE" ? t => t.done : t => !t.done;
      return this.todos.items.filter(predicate);
    }
  }

  get isAddTodoDisabled() {
    return this.newTodo.length < 4;
  }

  get isRemoveDoneTodosDisabled() {
    return this.todos.items.filter(item => item.done).length === 0;
  }

  onNewTodoChange(newTodo: string) {
    this.newTodo = newTodo;
  }

  onNewTodoClear() {
    this.newTodo = "";
  }

  onAddTodo() {
    this.store.dispatch(new ActionTodosAdd({ name: this.newTodo }));
    const addedMessage = this.translateService.instant(
      "anms.examples.todos.added.notification",
      { name: this.newTodo }
    );
    this.showNotification(addedMessage);
    this.newTodo = "";
  }

  onToggleTodo(todo: Todo) {
    this.store.dispatch(new ActionTodosToggle({ id: todo.id }));
    const newStatus = this.translateService.instant(
      `anms.examples.todos.filter.${todo.done ? "active" : "done"}`
    );
    const undo = this.translateService.instant("anms.examples.todos.undo");
    const toggledMessage = this.translateService.instant(
      "anms.examples.todos.toggle.notification",
      { name: todo.name }
    );
    this.showNotification(`${toggledMessage} ${newStatus}`, undo)
      .onAction()
      .subscribe(() => this.onToggleTodo({ ...todo, done: !todo.done }));
  }

  onRemoveDoneTodos() {
    this.store.dispatch(new ActionTodosRemoveDone());
    const removedMessage = this.translateService.instant(
      "anms.examples.todos.remove.notification"
    );
    this.showNotification(removedMessage);
  }

  onFilterTodos(filter: TodosFilter) {
    this.store.dispatch(new ActionTodosFilter({ filter }));
    const filterToMessage = this.translateService.instant(
      "anms.examples.todos.filter.notification"
    );
    const filterMessage = this.translateService.instant(
      `anms.examples.todos.filter.${filter.toLowerCase()}`
    );
    this.showNotification(`${filterToMessage} ${filterMessage}`);
  }

  private showNotification(message: string, action?: string) {
    return this.snackBar.open(message, action, {
      duration: 2500,
      panelClass: "todos-notification-overlay"
    });
  }
}
