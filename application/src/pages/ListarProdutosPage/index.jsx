import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { getProdutosLogged } from '../../api/empresa'
import NavBar from '../../components/NavBar'
import LargeButton from '../../components/LargeButton'

export default function ListarProdutosPage() {

  const [produtos, setProdutos] = useState([])
  const navigate = useNavigate()
  useEffect(()=>{
      async function load(){
        try{
          const prods = await getProdutosLogged()
          setProdutos(prods)
        }catch (err){
          if(err.response.status === 401){
            navigate("/login")
          }
        }
      }
      load()
    },[])

  return (
    <div>
      <NavBar/>
      <main>
        <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
      <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
          <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
              <tr>
                  <th scope="col" className="px-6 py-3">
                      ID
                  </th>
                  <th scope="col" className="px-6 py-3">
                      NOME
                  </th>
                  <th scope="col" className="px-6 py-3">
                      PREÇO
                  </th>
                  <th scope="col" className="px-6 py-3">
                      REMOVER
                  </th>
              </tr>
          </thead>
          <tbody>
          {produtos.map( produto =>
          <React.Fragment key={produto.id}>
            <tr className="bg-white border-b dark:bg-gray-900 dark:border-gray-700">
                  <th scope="row" className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                      {produto.id}
                  </th>
                  <td className="px-6 py-4">
                      {produto.nome}
                  </td>
                  <td className="px-6 py-4">
                      R$ {produto.preco.toFixed(2)}
                  </td>
                  <td className="px-6 py-4">
                      X
                  </td>
              </tr>
          </React.Fragment>
          )}
          </tbody>
      </table>
      <LargeButton text="Adicionar novo produto" action={()=> navigate("empresas/"+produtos[0].empresa.id+"/novoProduto")}/>

  </div>
      </main>
  </div>
  )
}
