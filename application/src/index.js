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
import CartPage from "./pages/CartPage";
import MeusPedidosPage from "./pages/MeusPedidosPage";
import SigninCompPage from './pages/SigninCompPage';

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
    path: "/signin-comp",
    element: <SigninCompPage/>
  },
  {
    path: "empresas/:empresaId/novoProduto",
    element: <NewProdPage/>
  },
  {
    path: "empresas/:empresaId/carrinho",
    element: <CartPage/>
  },
  {
    path: "meuspedidos",
    element: <MeusPedidosPage/>
  }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

