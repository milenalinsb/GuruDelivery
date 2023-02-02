import React, {useEffect, useState} from 'react'
import HeaderCard from '../../components/HeaderCard'
import InputText from '../../components/InputText'
import NavBar from '../../components/NavBar'
import ProductCard from '../../components/ProductCard'
import SearchBar from '../../components/SearchBar'
import Separator from '../../components/Separator'
import {useNavigate, useParams} from "react-router-dom";
import {addProdutoCarrinho, getEmpresa, getProdutos} from "../../api/empresa";
import Toast from "../../components/Toast";

export default function CompPage() {

  const {empresaId} = useParams()
  const [empresa, setEmpresa] = useState({});
  const [produtos, setProdutos] = useState([]);
  const navigate = useNavigate()

  useEffect(()=>{
    async function load(){
      const emp = await getEmpresa(empresaId)
      setEmpresa(emp)
    }
    load()
  },[])

  useEffect(()=>{
    async function load(){
      try{
        const prods = await getProdutos(empresaId)
        setProdutos(prods)
      }catch (err){
        if(err.response.status === 401){
          navigate("/login")
        }
      }
    }
    load()
  },[])

  async function addProdCarrinho(prod, quant){
    const resp = await addProdutoCarrinho(empresa.id, prod.id, quant)
    alert("Produto Adicionado com Sucesso")
  }

  return (
      <>
        <NavBar shopCart/>
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
                  <React.Fragment key={produto.id}>
                    <ProductCard
                        nome={produto.nome}
                        foto={produto.foto}
                        preco={produto.preco.toFixed(2)}
                        descricao={produto.descricao}
                        onAction={(quant)=>addProdCarrinho(produto, quant)}
                    />
                  </React.Fragment>
              )}
            </main>
          </div>
        </div>
      </>
  )
}
