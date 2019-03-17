import React, { Component } from 'react';
import PropTypes from 'prop-types';

export class TodoItem extends Component {
  render() {
    const {id, title, archived } = this.props.todo;
    let button;
    if (!archived) {
      button = <button onClick={this.props.archiveTodo.bind(this, id)} className="btn" style={btnStyle}>Archive</button>
    }
    return (
      <div style={itemStyle}>
       <p>
         {title}
         {button}
       </p>
      </div>
    )
  }
}

// PropTypes
TodoItem.propTypes = {
  todo: PropTypes.object.isRequired
}

const itemStyle = {
  backgroundColor: '#f4f4f4',
  padding: '2px 0px 2px 2px',
  borderBottom: '1px #ccc dotted'
}

const btnStyle = {
 // color: '#f00',
  float: 'right',
}

export default TodoItem