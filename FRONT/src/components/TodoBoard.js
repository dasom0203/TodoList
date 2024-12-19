import React from "react";
import TodoItem from "./TodoItem";
import { Col, Row } from 'antd';


function TodoBoard(props) {

    console.log('todoBoard',props.todoList)
    return (    
        <div>
            <h1>Todo List</h1>
            <Row gutter={[16, 16]}  style={{ display: "flex", flexDirection: "column" }} >
                {props.todoList.map((item) => (
                    <TodoItem key={item.todoNum} item={item} />
                ))}
            </Row>
        </div>
    )
}

export default TodoBoard