import React, {useEffect, useState} from 'react';
import NavBar from "../../components/NavBar";
import HeaderCard from "../../components/HeaderCard";
import {deleteFromCarrinho, getCarrinho, getEmpresa} from "../../api/empresa";
import {useNavigate, useParams} from "react-router-dom";
import CartItem from "../../components/CartItem";

function CartPage() {

    const [empresa, setEmpresa] = useState({})
    const [carrinho, setCarrinho] = useState([]);

    const {empresaId} = useParams()
    const navigate = useNavigate()

    //Carregar Empresa
    useEffect(()=>{
        async function load(){
            try {
                const emp = await getEmpresa(empresaId)
                setEmpresa(emp)
            }catch (err){
                if(err.response.status === 401){
                    navigate("/login")
                }
            }
        }
        load()
    },[])

    //Carregar Itens do carrinho
    useEffect(()=>{
        updateCart()
    },[])

    async function updateCart(){
        try {
            const carrinho = await getCarrinho(empresaId)
            setCarrinho(carrinho)
            console.dir(carrinho)
        }catch (err){
            if(err.response.status === 401){
                navigate("/login")
            }
        }
    }

    async function handleDelete(item){
        console.dir(item)
        await deleteFromCarrinho(empresa.id, item.produto.id)
        updateCart()
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
                </div>
                <main className="flex flex-col w-full my-3">
                    {carrinho.map( item => (
                        <div className="my-2">
                            <CartItem
                                nome={item.produto.nome}
                                foto={item.produto.foto}
                                quantidade={item.quantidade}
                                onAction={() => handleDelete(item)}
                            />
                        </div>
                    ))}
                    <CartItem/>
                    <CartItem/>
                    <CartItem/>
                </main>
            </div>
        </>
    );
}

export default CartPage;