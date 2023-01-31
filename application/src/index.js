import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import LoginPage from './pages/LoginPage';
import CompPage from './pages/CompPage';
import 'flowbite';
import SigninUserPage from './pages/SigninUserPage';

const router = createBrowserRouter([
  {
    path: "/",
    element: <LoginPage/>,
  },
  {
    path: "/login",
    element: <LoginPage/>,
  },
  {
    path: "/empresa",
    element: <CompPage/>
  },
  {
    path: "/signin-usr",
    element: <SigninUserPage/>
  }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

