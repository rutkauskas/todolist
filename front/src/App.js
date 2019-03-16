import React, { Component } from 'react';
import Header from './components/layout/Header';
import Todos from './components/Todos';

import './App.css';

class App extends Component {
  state = {
    todos: [
      {
        id: 1,
        title: 'Todo Task 1',
        archived: false
      },
      {
        id: 2,
        title: 'Todo Task 2',
        archived: false
      },
      {
        id: 3,
        title: 'Todo Task 3',
        archived: false
      }
    ]
  }

  render() {
    return (
      <div className="App">
        <Header />
        <Todos todos={this.state.todos}/>
      </div>
    );
  }
}

export default App;
