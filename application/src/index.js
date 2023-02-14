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
import AuthContext from './context/AuthContext';
import ListarProdutosPage from './pages/ListarProdutosPage';
import HomePage from './pages/HomePage';

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
    path: "meusprodutos/empresas/:empresaId/novoProduto",
    element: <NewProdPage/>
  },
  {
    path: "empresas/:empresaId/carrinho",
    element: <CartPage/>
  },
  {
    path: "meuspedidos",
    element: <MeusPedidosPage/>
  },
  {
    path: "meusprodutos",
    element: <ListarProdutosPage/>
  },
  {
    path:"home",
    element: <HomePage/>
  }


]);

const loggedUser = JSON.parse(localStorage.getItem("user"))


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AuthContext.Provider value={{user: loggedUser}}>
      <RouterProvider router={router} />
    </AuthContext.Provider>
  </React.StrictMode>
);

