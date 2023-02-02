import React, {useEffect, useState} from 'react'
import HeaderCard from '../../components/HeaderCard'
import InputText from '../../components/InputText'
import NavBar from '../../components/NavBar'
import ProductCard from '../../components/ProductCard'
import SearchBar from '../../components/SearchBar'
import Separator from '../../components/Separator'
import {useParams} from "react-router-dom";
import {getEmpresa, getProdutos} from "../../api/empresa";

export default function CompPage() {

  const {empresaId} = useParams()
  const [empresa, setEmpresa] = useState({});
  const [produtos, setProdutos] = useState([]);

  useEffect(()=>{
    async function load(){
      const emp = await getEmpresa(empresaId)
      setEmpresa(emp)
    }
    load()
  },[])

  useEffect(()=>{
    async function load(){
      const prods = await getProdutos(empresaId)
      setProdutos(prods)
      console.dir(prods)
    }
    load()
  },[])

  return (
    <>
      <NavBar/>
    <div className='flex flex-1 flex-col p-5 bg-background items-center justify-center' >
      <div className=' max-w-6xl w-full rounded-lg'>
        <header className='w-full flex text-on-primary'>
          <HeaderCard
              email={empresa.email}
              nome={empresa.nome}
              telefone={empresa.telefone}
              foto={empresa.fotoPerfil}
          />
        </header>
        <div className='mt-2'>
          <SearchBar placeholder="Procure um produto" buttonText="Procurar"/>
        </div>
        <main className='grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 bg-background justify-center gap-2 mt-2'>
          {produtos.map( produto =>
            <ProductCard
                nome={produto.nome}
                foto={produto.foto}
                preco={produto.preco.toFixed(2)}
                descricao={produto.descricao}
            />
          )}
        </main>
      </div>
    </div>
    </>
  )
}
