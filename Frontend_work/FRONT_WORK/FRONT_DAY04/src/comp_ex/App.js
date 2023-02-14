import React, { useState, useEffect } from "react";
import "./App.css";

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
  return (
    <li>
      <p>
        <input
          checked={item.done ? "checked" : ""}
          type="checkbox"
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
      <ol>
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
    setTodoList(newList);
    saveLocalStorage(newList, noCount);
  }

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
