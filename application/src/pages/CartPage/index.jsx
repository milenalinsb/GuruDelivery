import React, {useEffect, useState} from 'react';
import NavBar from "../../components/NavBar";
import HeaderCard from "../../components/HeaderCard";
import {deleteFromCarrinho, getCarrinho, getEmpresa, postPedido} from "../../api/empresa";
import {useNavigate, useParams} from "react-router-dom";
import CartItem from "../../components/CartItem";
import {getEnderecos} from "../../api/user";

function CartPage() {

    const [empresa, setEmpresa] = useState({})
    const [carrinho, setCarrinho] = useState([]);
    const [enderecos, setEnderecos] = useState([]);
    const [selectedEndereco, setSelectedEndereco] = useState(1);

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

    //Carregar Endereços
    useEffect(()=>{
        async function load(){
            const list = await getEnderecos()
            setEnderecos(list)
            console.dir(list)
        }
        load()
    },[])

    async function updateCart(){
        try {
            const carrinho = await getCarrinho(empresaId)
            setCarrinho(carrinho)
        }catch (err){
            if(err.response.status === 401){
                navigate("/login")
            }
        }
    }

    async function handleDelete(item){
        await deleteFromCarrinho(empresa.id, item.produto.id)
        updateCart()
    }

    function handleChangeEnd(endereco){
        setSelectedEndereco(endereco.id)
    }

    async function realizarPedido(){
        const data = await postPedido(empresa.id, selectedEndereco)
        alert("Pedido Realizado com Sucesso")
        navigate(0)
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
                <main className="flex flex-col w-full my-3 max-w-6xl">
                    {carrinho.map( item => (
                        <div key={item.produto.id} className="my-2">
                            <CartItem
                                nome={item.produto.nome}
                                foto={item.produto.foto}
                                quantidade={item.quantidade}
                                onAction={() => handleDelete(item)}
                            />
                        </div>
                    ))}
                    <div>
                        {enderecos.map( end => (
                            <div key={end.id} className="flex bg-surface rounded shadow p-2 text-sm">
                                <fieldset className="flex items-center gap-2">
                                    <input
                                        id={end.id}
                                        name="endereco"
                                        type="radio"
                                        onClick={() => handleChangeEnd(end)}
                                    />
                                        <label htmlFor={end.id} >
                                        {end.rua}, {end.numero}, {end.bairro} ,{end.cep}, {end.cidade}
                                    </label>
                                </fieldset>
                            </div>
                        ))}
                    </div>
                    <button
                        className="self-end bg-primary text-on-primary p-2 rounded my-2"
                        onClick={realizarPedido}
                    >Finalizar</button>
                </main>

            </div>
        </>
    );
}

export default CartPage;