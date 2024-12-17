import React from "react";
import { Checkbox } from 'antd';
import axios from "axios";

function TodoItem({ item }) {

    // Todo 완료 상태 변경
    const onChange = (checked) => {
        // console.log(`checked = ${e.target.checked}`);
        console.log("todo체크박스 상태 확인!", checked);

        // 상태 값 토글
        const newStatus = checked ? '완료' : '미완료';

        // [PUT] /todo/status
        axios.put('/todo/status',{
            todoNum:item.todoNum,
            todoStatus:newStatus
        })
        .then(function(response){
            console.log("업데이트 성공!",response);
        })
        .catch(function(error){
            console.log("item 완료 실패!!");
        })
    };

    return (
        // 일정 목록

        <div className="todo-item">
            <Checkbox
                // 체크박스의 상태 (true/false)를 가지고 온다.
                onChange={(e) => onChange(e.target.checked)}
                checked={item.todoStatus == '완료'}>{item.todoContent}</Checkbox>
            <p>{item.todoImportant ? '중요' : '일반'}</p>
        </div>

    );
}

export default TodoItem