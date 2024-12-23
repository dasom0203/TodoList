import React, { useState, useEffect } from 'react';
import './App.css';
import axios from 'axios';
import TodoBoard from './components/TodoBoard';
// import { DownOutlined } from '@ant-design/icons'; // 드롭다운 Ant-Design
// import { Dropdown, Space, Typography } from 'antd'; // 드롭다운 Ant-Design
import { Radio } from 'antd'; // 라디오 버튼
import { PlusCircleOutlined } from '@ant-design/icons'; // + 버튼 Ant-Design
// import customAxios from './customAxios';
import { Col, Row } from 'antd';


// Todo List 만들기
// ▶ 중요 여부 체크 + 인풋창 + 추가 버튼
// ▶ 인풋창에 값을 입력하고 추가 버튼을 누르면 아이템이 추가된다
// ▶ 아이템 수정 버튼을 누르면 내용, 중요 여부 수정이 가능하다.
// ▶ 아이템 삭제 버튼을 누르면 삭제가 가능하다.
// ▶ 필터링 보기 드롭다운 버튼을 누르면 완료/미완료/전체 선택이 가능하고, 필터링 조회가 가능하다
// ▶ 아이템 옆의 체크박스를 선택하면 상태가 완료로 변경되고 화면에서 사라진다.

// const headerStyle = {
//   textAlign: 'center',
//   color: '#fff',
//   height: 64,
//   paddingInline: 48,
//   lineHeight: '64px',
//   backgroundColor: '#4096ff',
// };
// const contentStyle = {
//   textAlign: 'center',
//   minHeight: 120,
//   lineHeight: '120px',
//   color: '#fff',
//   backgroundColor: '#0958d9',
// };
// const layoutStyle = {
//   borderRadius: 8,
//   overflow: 'hidden',
//   width: 'calc(50% - 8px)',
//   maxWidth: 'calc(50% - 8px)',
// };


function App() {


  // state 선언
  // 입력값 -  초기 값은 알 수 없으므로 빈 값
  const [inputValue, setInputValue] = useState('')

  // 아이템을 모아두는 배열
  const [todoList, setTodoList] = useState([])

  // todo 중요 여부 변수
  const [important, setImportant] = useState(false) // 기본 false

  // 아이템 전체 보기
  const todos = async () => {
    console.log("todos 함수 실행!")

    await axios.get('/todo')
      .then(function(response){
        console.log(response);
        setTodoList(response.data); // 서버에서 받은 todo 목록으로 상태 업데이트
      })
      .catch(function(error){
        console.log("실패");
        console.log(error);
      });

    //setTodoList(response.data); // 서버에서 받은 todo 목록으로 상태 업데이트
  }

   // 첫 화면 로드 시 데이터 가져오기 (useEffect)
   useEffect(() => {
    todos(); // 컴포넌트가 마운트 될 때 todos 함수 호출하여 데이터를 가져옴
  }, []); // 빈 배열을 두 번째 인수로 넣으면, 컴포넌트가 처음 마운트 될 때만 실행됩니다.

  // 새 Todo 추가 (비동기)
  const addItem = async () => {
    console.log("addItem 함수 실행!!", inputValue, "important",important);

    // Post 요청 
    await axios.post('/todo',
      {
        todoContent:inputValue,
        todoImportant:important
      })
      .then(function(response){
        console.log(response);
      })
      .catch(function(error){
        console.log("실패");
        console.log(error);
      });

    // 새로운 todo 목록 가져오기
    await todos(); // todo 목록을 가져오는 함수

    // input 창 초기화
    setInputValue('');
    setImportant(false);
  }




  // // 드롭다운 데이터
  // const items = [
  //   {
  //     key: '1',
  //     label: '기본(미완료)',
  //   },
  //   {
  //     key: '2',
  //     label: '완료',
  //   },
  //   {
  //     key: '3',
  //     label: '전체',
  //   },
  // ];

  // 라디오 버튼 호출 함수
  const [value, setValue] = useState('미완료');
  const onChange = (e) => {
    console.log('radio checked', e.target.value);
    setValue(e.target.value);
  };


  return (
    <main>
      
      <h1 className='title'>TODO LIST</h1>
      <p className='subtitle'>✨Todo List 페이지 입니다!✨</p>

      <Row gutter={[16, 16]} justify="center">
          {/* 라디오 버튼 */}
          <Radio.Group onChange={onChange} value={value}>
            <Radio value={'미완료'}>미완료</Radio>
            <Radio value={'완료'}>완료</Radio>
            <Radio value={'전체'}>전체</Radio>
          </Radio.Group>
        </Row>

        <Row gutter={[16, 16]} justify="center">
          <br/> <br/>
          {/* 중요한 일정 체크박스 */}
          <Col span={6} style={{ textAlign: "center", display: "flex"}}>
          <label><input type="checkbox" checked={important} onChange={() => setImportant(!important)}/>중요!</label>
          {/* 일정 입력 input 창 */}
          <input value={inputValue} className='todoInput' type="text" onChange={(event)=>setInputValue(event.target.value)} placeholder="할 일을 입력하세요" ></input>
          {/* 일정 추가 버튼, 버튼을 누르면 addItem 함수 실행 */}
          <button onClick={addItem} className='addItemButton' disabled={!inputValue}><PlusCircleOutlined /></button>   
          </Col>
        </Row>

      <br/> <br/>
      <Row gutter={[16, 16]} justify="center">  
          {/* todoList */}
          <TodoBoard todoList={todoList} todos={todos}></TodoBoard>
      </Row>

    </main>
  );

 
}

export default App;