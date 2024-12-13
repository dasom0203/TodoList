import React from "react";
import { Checkbox } from 'antd';

function TodoItem({ item }) {

    const onChange = (e) => {
        console.log(`checked = ${e.target.checked}`);
    };

    return (
        // 일정 목록

        <div className="todo-item">
            <Checkbox
                onChange={() => onChange(item.todoNum)}
                checked={item.todoStatus == '완료'}>{item.todoContent}</Checkbox>
            <p>{item.todoImportant ? '중요' : '일반'}</p>
        </div>

    );
}

export default TodoItem