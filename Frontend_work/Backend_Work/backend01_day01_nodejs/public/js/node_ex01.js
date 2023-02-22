console.log(">>> Promise exam");

function task(fullfill, reject) {
  console.log("task 실행 ... ");
  setTimeout(function () {
    console.log("task 실행 끝!");
    //fullfill("실행 결과 값");
    reject("Error message!");
  }, 1000);
}

function fullfilled(result) {
  console.log("task 끝난 후 >>> fullfilled 실행 >>> ", result);
}

function rejected(err) {
  console.log("task에서 reject 실행 >>> rejected 실행 >>> ", err);
}

new Promise(task).then(fullfilled, rejected);
