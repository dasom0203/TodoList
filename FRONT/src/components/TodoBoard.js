import React from "react";
import TodoItem from "./TodoItem";
import { Col, Row } from 'antd';


function TodoBoard({todoList, todos}) {
    console.log('todoBoard!!', todoList); // todoList가 제대로 들어오는지 확인
    // console.log('todoBoard',props.todoList)
    return (    
        <div>
            <h1>Todo List</h1>
            <Row gutter={[16, 16]}  style={{ display: "flex", flexDirection: "column" }} >
                {todoList.map((item) => (
                    <TodoItem key={item.todoNum} item={item} todos={todos} />
                ))}
            </Row>
        </div>
    )
}

export default TodoBoard