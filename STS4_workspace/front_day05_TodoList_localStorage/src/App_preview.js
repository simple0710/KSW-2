import React, { useEffect, useState } from "react";
import "./App.css";

function ItemRow({ item, removeItem, updateItem }) {
  const [isDisabled, setDisabled] = useState(true);
  const [title, setTitle] = useState(item.title);
  return (
    <li>
      <p>
        <input
          type="checkbox"
          onChange={(e) => {
            item.done = e.target.checked;
            updateItem(item);
          }}
          checked={item.done ? "checked" : ""}
        />
        <input
          type="text"
          value={title}
          disabled={isDisabled ? "disabled" : ""}
          className={item.done ? "done" : "not-done"}
          onChange={(e) => {
            setTitle(e.target.value);
          }}
        />
        <button
          onClick={(e) => {
            removeItem(item.no);
          }}
        >
          삭제
        </button>
        <button
          onClick={(e) => {
            if (isDisabled) {
              setDisabled(false);
            } else {
              setDisabled(true);
              item.title = title;
              updateItem(item);
            }
          }}
        >
          {isDisabled ? "수정" : "수정완료"}
        </button>
      </p>
    </li>
  );
}

function InputItem({ appendItem }) {
  // input의 value로 사용 할 경우 초기값 필수.
  const [newWork, setNewWork] = useState("");
  return (
    <div>
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
          appendItem(newWork);
        }}
      >
        추가
      </button>
    </div>
  );
}

// Redux를 이용하면 해결된다.
function TodoList({ todoList, removeItem, updateItem }) {
  return (
    <div>
      <ul>
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
      </ul>
    </div>
  );
}

function App(props) {
  // const [todoList, setTodoList] = useState([
  //   { no: 1, title: "점심 먹기", done: false },
  //   { no: 2, title: "산책 하기", done: false },
  //   { no: 3, title: "배운 것 복습하기", done: false },
  //   { no: 4, title: "내일 수업 예습하기", done: false },
  // ]);
  // const [noCount, setNoCount] = useState(5);
  const [todoList, setTodoList] = useState([]);
  const [noCount, setNoCount] = useState(1);
  useEffect(() => {
    console.log(">>> useEffect ...");
    const localStorageData = localStorage.getItem("todoListData");
    console.log(localStorageData);
    if (localStorageData) {
      let todoListData = JSON.parse(localStorageData);
      setTodoList(todoListData.todoList);
      setNoCount(todoListData.noCount);
      console.log(">>> complate load ...");
    }
  }, []);
  // 과제 1 : 취소선 기능 추가.
  // 과제 2 : todoList 데이터를 localStorage에 저장.
  function saveLocalStorage(newList, newCnt) {
    localStorage.setItem(
      "todoListData",
      JSON.stringify({ noCount: newCnt, todoList: newList })
    );
    console.log(">>>> 저장 성공!", todoList.length);
  }

  function appendItem(newItem) {
    console.log(noCount);
    const newList = [...todoList, { no: noCount, title: newItem, done: false }];
    const newCnt = noCount + 1;
    setTodoList(newList);
    setNoCount(newCnt);
    saveLocalStorage(newList, newCnt);
  }
  function removeItem(no) {
    var newList = todoList.filter((item, idx) => {
      return item.no != no;
    });
    setTodoList(newList);
    saveLocalStorage(newList, noCount);
  }

  function updateItem(item) {
    let idx = todoList.findIndex((todo, idx) => {
      return todo.no == item.no;
    });
    todoList[idx] = item;
    const newList = [...todoList];
    setTodoList(newList);
    saveLocalStorage(newList, noCount);
  }
  return (
    <>
      <h1>Todo List</h1>
      <InputItem appendItem={appendItem} />
      <hr />
      <TodoList
        todoList={todoList}
        removeItem={removeItem}
        updateItem={updateItem}
      />
    </>
  );
}

export default App;
