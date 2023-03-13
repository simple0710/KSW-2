import React, { useEffect, useState } from "react";
import "./App.css";

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
        />
        <input
          value={title}
          onChange={(e) => {
            setTitle(e.target.value);
          }}
          className={item.done ? "done" : "not-done"}
          type="text"
          readOnly={mode ? "" : "readonly"}
          onClick={(e) => {
            setMode(true);
          }}
          onBlur={(e) => {
            item.title = title;
            updateItem(item);
            setMode(false);
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
            setMode(!mode);
            if (mode) {
              item.title = title;
              updateItem(item);
            } else {
            }
          }}
        >
          {mode ? "수정완료" : "수정"}
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
        onKeyDown={(e) => {
          if (e.key === "Enter") {
            appendItem(newWork);
            setNewWork("");
          }
        }}
      />
      <button
        onClick={(e) => {
          appendItem(newWork);
          setNewWork("");
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
    // fetch() 기능 : javascript 기본 내장된 Ajax 기능.
    // Ajax를 이용해서 백엔드의 데이터를 요청 한다.
    const requestOptions = {
      method: "GET",
      headers: { "Content-Type": "application/json" },
    };
    fetch("http://localhost:7788/todo", requestOptions)
      .then((response) => response.json())
      .then((respObj) => {
        setTodoList(respObj.data);
      })
      .catch((error) => {
        console.error("실패:", error);
      });
  }, []);

  function save(method, newItem) {
    const requestOptions = {
      method: method,
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newItem),
    };
    fetch("http://localhost:7788/todo", requestOptions)
      .then((response) => response.json())
      .then((respObj) => {
        setTodoList(respObj.data);
      })
      .catch((error) => {
        console.error("실패:", error);
      });
  }

  function appendItem(title) {
    save("POST", { userId: "kim", title: title });
  }
  function removeItem(no) {
    save("DELETE", { no: no });
  }

  function updateItem(item) {
    save("PUT", item);
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
