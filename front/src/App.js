import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Header from './components/layout/Header';
import Todos from './components/Todos';
import AddTodo from './components/AddTodo';
import uuid from 'uuid';
import axios from 'axios';

import './App.css';

class App extends Component {
  state = {
    todos: []
  }

  componentDidMount() {
    axios.get('http://localhost:8080/')
      .then(res => this.setState({ todos : res.data }))
  }

  //Add Todo
  addTodo = (title) => {
    axios.post('http://localhost:8080/', {
      id: uuid.v4(),
      title,
      archived: false
    })
      .then(res => this.setState({ todos : [...this.state.todos, res.data]
     }));

  }

  //Archive Todo
  archiveTodo = (id) => {
    axios.put(`http://localhost:8080/${id}`, {
      archived: true
    })
      .then(res => this.setState({ todos: this.state.todos.map(todo => {
        if(todo.id === id) {
          todo.archived = true
        }
        return todo;
      }) }));
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
