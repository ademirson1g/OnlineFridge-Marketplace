import React, { Component } from "react";

const TodoItem = ({text}) => (
	<li>{text}</li>
  );
  
  class CustomListPage extends Component {
	constructor(props) {
	  super(props);
	  this.state = {
		todos: [],
		newTodo: ''
	  };
	  this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleSubmit(e) {
	  e.preventDefault();
	  const todos = [...this.state.todos, this.state.newTodo];
	  this.setState({todos, newTodo: ''});
	}

	render() {
	  const {newTodo} = this.state;
	  const todos = this.state.todos.map((t, i) => (
		<TodoItem key={i} text={t} />
	  ));
	  
	  return (
		<div className="App">
		  <h1>Simple Shopping List</h1>
		  <form onSubmit={this.handleSubmit}>
			<input
			  className="todo-input"
			  autoComplete="off"
			  type="text"
			  name="newTodo"
			  placeholder="Add List"
			  value={newTodo}
			  onChange={(e) => this.setState({[e.target.name]: e.target.value })}
			/>
			<button
			  type="submit"
			  className="save-button"
			>
			  SAVE
			</button>
		  </form>
		  <div className="todo-content">
			<ol>
			  {todos}
			</ol>
		  </div>
		</div>
	  );
	}
  }

  export default CustomListPage