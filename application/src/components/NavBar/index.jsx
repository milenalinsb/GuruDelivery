import React, { useContext, useEffect } from 'react'
import {Link} from "react-router-dom";
import AuthContext from '../../context/AuthContext';
import cartItem from "../CartItem";

export default function NavBar({shopCart}) {

  const auth = useContext(AuthContext)

  return (
      <>
        <nav className="bg-primary border-gray-200 px-2 sm:px-4 py-2.5 rounded dark:bg-gray-900 ">
          <div className="container flex flex-wrap items-center mx-auto gap-5 text-on-primary">
            <Link to="/home" className="flex items-center">
              <img src="/assets/logo/logo.svg" className="h-6 mr-3 sm:h-9" alt="Logo" />
              <span className="self-center text-xl font-semibold whitespace-nowrap dark:text-white">GuruDelivery</span>
          </Link>
            <button data-collapse-toggle="navbar-default" type="button" className="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="navbar-default" aria-expanded="false">
              <span className="sr-only">Open main menu</span>
              <svg className="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fillRule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clipRule="evenodd"></path></svg>
            </button>
            <div className="hidden w-full md:block md:w-auto" id="navbar-default">
              <ul className=" text-on-primary flex flex-col p-4 mt-4 border border-gray-100 rounded-lg md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium md:border-0 dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
                {auth.user.role === 'ROLE_USER'
                ?<>
                  <li>
                    <Link to="/meuspedidos">
                      Meus Pedidos
                    </Link>
                  </li>
                </>
                :null}

                {auth.user.role === 'ROLE_EMPRESA'
                ?<>
                  <li>
                    <Link to="/meusprodutos">
                      Listar Produtos
                    </Link>
                  </li>
                  <li>
                    <a href="#" className="block py-2 pl-3 pr-4 text-white rounded md:bg-transparent md:p-0 dark:text-white" aria-current="page">Listar Pedidos</a>
                  </li>
                </>
                :null}
                
                <ul>
                  {shopCart?(
                      <li className="self-end w-6 text-on-primary">
                        <Link to={`/empresas/${shopCart}/carrinho`}>
                          <img src="/assets/icons/shopping-cart.svg" alt="Carrinho" />
                        </Link>
                      </li>
                  ):""}
                </ul>
              </ul>

            </div>

          </div>
        </nav>
      </>
  )
}
