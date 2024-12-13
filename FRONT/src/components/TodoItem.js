import React from "react";
import { Checkbox } from 'antd';

function TodoItem(props){

    const onChange = (e) => {
        console.log(`checked = ${e.target.checked}`);
      };
    
    return(
        <div className="todo-item">
            <Checkbox onChange={onChange}>{props.item}</Checkbox>
        </div>
    )
}

export default TodoItem