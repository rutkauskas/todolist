import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Header from './components/layout/Header';
import Todos from './components/Todos';
import AddTodo from './components/AddTodo';
import uuid from 'uuid';

import './App.css';

class App extends Component {
  state = {
    todos: [
      {
        id: uuid.v4(),
        title: 'Todo Task 1',
        archived: false
      },
      {
        id: uuid.v4(),
        title: 'Todo Task 2',
        archived: true
      },
      {
        id: uuid.v4(),
        title: 'Todo Task 3',
        archived: false
      }
    ]
  }

  addTodo = (title) => {
    const newTodo = {
      id: uuid.v4(),
      title,
      archived: false
    }
    this.setState({ todos: [...this.state.todos, newTodo] });
    console.log(title)
  }

  //Archive Todo
  archiveTodo = (id) => {
    this.setState({ todos : this.state.todos.map(todo => {
      if(todo.id === id) {
        todo.archived = true
      }
      return todo;
    })});
  }

  render() {
    return (
      <Router>
        <div className="App">
          <div className="container">
            <Header />
            <Route exact path="/" render={props => (
              <React.Fragment>
                <AddTodo addTodo={this.addTodo}/>
                <Todos todos={this.state.todos.filter(todo => todo.archived !== true)} archiveTodo={this.archiveTodo}/>
              </React.Fragment>
            )} />
            <Route path="/archived" render={props => (
              <React.Fragment>
                <Todos todos={this.state.todos.filter(todo => todo.archived !== false)} archiveTodo={this.archiveTodo}/>
              </React.Fragment>
            )} />
          </div>
        </div>
      </Router>
    );
  }
}

export default App;
