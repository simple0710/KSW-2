import React, { useState, useEffect } from "react";
import "./App.css";

<<<<<<< Updated upstream
function InputItem({ appendItem }) {
  // input의 value로 사용 할 경우 초기값 필수.
  const [inputWork, setInputWork] = useState("");
  return (
    <div>
      <input
        type="text"
        value={inputWork}
        onChange={(e) => {
          setInputWork(e.target.value);
        }}
      />
      <button
        onClick={(e) => {
          if (inputWork) {
            appendItem(inputWork);
            setInputWork("");
          }
        }}
      >
        입력
      </button>
    </div>
  );
}
function ItemRow({ item, removeItem, updateItem }) {
  const [mode, setMode] = useState(false);
  const [title, setTitle] = useState(item.title);
=======
function ItemRow({ item, removeItem }) {
  const [doneCheck, newDoneCheck] = useState(item.done);
>>>>>>> Stashed changes
  return (
    <li>
      <p>
        <input
          checked={item.done ? "checked" : ""}
          type="checkbox"
<<<<<<< Updated upstream
          onChange={(e) => {
            item.done = e.target.checked;
            updateItem(item);
          }}
        ></input>
        <input
          type="text"
          value={title}
          className={` ${item.done ? "check" : ""}`}
          disabled={mode ? false : true}
          onChange={(e) => {
            setTitle(e.target.value);
          }}
        />
=======
          checked={doneCheck ? true : false}
          onChange={(e) => {
            localStorage.getItem(0);
            newDoneCheck(!doneCheck);
          }}
        />
        <input type="text" style={{textDecoration: doneCheck ? "line-through" : "none"}} value={item.title} disabled />
>>>>>>> Stashed changes
        <button
          onClick={(e) => {
            setMode(!mode);
            if (mode) {
              item.title = title;
              updateItem(item);
            }
          }}
        >
          {!mode ? "수정" : "수정 완료"}
        </button>
        <button
          type="button"
          onClick={(e) => {
            removeItem(item.no);
          }}
        >
          삭제
        </button>
      </p>
    </li>
  );
}

function TodoList({ todoList, removeItem, updateItem }) {
  return (
    <div>
<<<<<<< Updated upstream
      <ol>
=======
      할일 :
      <input
        type="text"
        value={newWork}
        onChange={(e) => {
          setNewWork(e.target.value);
        }}
      />
      <button
        onClick={(e) => {
          if (newWork) {
            appendItem(newWork);
            setNewWork("");
          }
        }}
      >
        추가
      </button>
    </div>
  );
}

// Redux를 이용하면 해결된다.
function TodoList({ todoList, removeItem }) {
  return (
    <div>
      <ul>
>>>>>>> Stashed changes
        {todoList.map((item, idx) => {
          return (
            <ItemRow
              key={item.no}
              item={item}
              removeItem={removeItem}
              updateItem={updateItem}
            />
          );
        })}
      </ol>
    </div>
  );
}

function App(props) {
<<<<<<< Updated upstream
  const [todoList, setTodoList] = useState([]);
  const [noCount, setNoCount] = useState(1);
  useEffect(() => {
    const localStorageData = localStorage.getItem("todoListData");
    if (localStorageData) {
      let objData = JSON.parse(localStorageData);
      setTodoList(objData.todoList);
      setNoCount(objData.noCount);
      console.log("data load완료");
    }
  }, []);
=======
  // 과제 1 : 취소선 기능 추가
  // 과제 2 : todoList 데이터를 LocalStorage에 저장
  const [todoList, setTodoList] = useState([
    { no: 1, title: "점심 먹기", done: false },
    { no: 2, title: "산책 하기", done: false },
    { no: 3, title: "배운 것 복습하기", done: false },
    { no: 4, title: "내일 수업 예습하기", done: false },
  ]);
  // 과제 2
  todoList.forEach(element => {
    window.localStorage.setItem(element.no, element.title);
    console.log(window.localStorage.getItem(element.no));

  });
  const [noCount, setNoCount] = useState(5);
>>>>>>> Stashed changes

  function saveLocalStorage(newList, noCnt) {
    localStorage.setItem(
      "todoListData",
      JSON.stringify({ todoList: newList, noCount: noCnt })
    );
    console.log("저장 완료");
  }
  function appendItem(item) {
    let newList = [...todoList, { no: noCount, title: item, done: false }];
    let noCnt = noCount + 1;
    setTodoList(newList);
    setNoCount(noCnt);
    saveLocalStorage(newList, noCnt);
  }

  function removeItem(no) {
    var newList = todoList.filter((item, idx) => {
      return item.no != no;
    });
    window.localStorage.removeItem(no);
    setTodoList(newList);
    saveLocalStorage(newList, noCount);
  }
<<<<<<< Updated upstream

  function updateItem() {
    const newList = [...todoList];
    setTodoList(newList);
    saveLocalStorage(newList, noCount);
  }

  return (
    <>
      <div id="head">
        <h1>TodoList</h1>
        <InputItem appendItem={appendItem} />
      </div>
=======
  var color = "green";
  return (
    <>
      <h1 style={{color}}>Todo List</h1>
      <InputItem appendItem={appendItem} />
>>>>>>> Stashed changes
      <hr />
      <TodoList
        todoList={todoList}
        removeItem={removeItem}
        updateItem={updateItem}
      />
      <div id="body"></div>
    </>
  );
}

export default App;