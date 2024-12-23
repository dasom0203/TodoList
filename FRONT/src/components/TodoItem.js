import React from "react";
import { Checkbox } from 'antd';
import axios from "axios";
import { Col, Row } from 'antd';


function TodoItem({ item, todos }) {
    console.log("todos props 확인:", todos);
    // Todo 완료 상태 변경
    const onChange = async (checked) => {
        // console.log(`checked = ${e.target.checked}`);
        console.log("todo체크박스 상태 확인!", checked);

        // 상태 값 토글
        const newStatus = checked ? '완료' : '미완료';

        // [PUT] /todo/status
        try{
            await axios.put('/todo/status',{
                todoNum:item.todoNum,
                todoStatus:newStatus
            });
            console.log("업데이트 성공!");
            // 새로운 todo 목록 가져오기
            await todos(); // todo 목록을 가져오는 함수
        }
        catch(error){
            console.log("item 완료 실패!!", error);
        }
    };

    return (
        // 일정 목록
        <Col span={24} style={{ textAlign: "left" }}>
            <div className="todo-item">
                {/* 체크박스의 상태 (true/false)를 가지고 온다. */}
                <Checkbox onChange={(e) => onChange(e.target.checked)}
                    checked={item.todoStatus == '완료'}><span className="todo-content">{item.todoContent}</span></Checkbox>
                <p>{item.todoImportant ? '중요' : '일반'}</p>
            </div>
        </Col>

    );
}

export default TodoItem