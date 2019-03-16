import React, { Component } from 'react';
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
        archived: false
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

  render() {
    return (
      <div className="App">
        <div className="container">
          <Header />
          <AddTodo addTodo={this.addTodo}/>
          <Todos todos={this.state.todos}/>
        </div>
      </div>
    );
  }
}

export default App;
