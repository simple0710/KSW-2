import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Header from "./inc/Head.js";
import Main from "./inc/Main.js";
import Profile from "./inc/Profile.js";
import Gallery from "./inc/Gallery.js";
import Lecture from "./inc/Lecture.js";
import Contact from "./inc/Contact.js";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <h1>Hello World</h1>
        <Header />
        <Routes>
          <Route path="/" element={<Main />}></Route>
          <Route path="/profile" element={<Profile />}></Route>
          <Route path="/gallery" element={<Gallery />}></Route>
          <Route path="/lecture" element={<Lecture />}></Route>
          <Route path="/contact" element={<Contact />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
