import './App.css';
import { Navigate, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import SignUp from "./components/SignUp";
import Navbar from "./components/Navbar";
import Movies from "./components/Movies";

function App() {
  return (
    <div>
      <Navbar/>
      <Routes>
        <Route
          path="/"
          element={<Navigate to="/login" replace/>}
        />
        <Route path="/login" element={<Login/>}/>
        <Route path="/signup" element={<SignUp/>}/>
        <Route path="/movies" element={<Movies/>}/>
      </Routes>
    </div>
  );
}

export default App;
