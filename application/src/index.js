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
import NewProdPage from './pages/NewProdPage';

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
    path: "/empresas/:empresaId",
    element: <CompPage/>
  },
  {
    path: "/signin-usr",
    element: <SigninUserPage/>
  },
  {
    path: "empresa/:empresaId/novoProduto",
    element: <NewProdPage/>
  }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

