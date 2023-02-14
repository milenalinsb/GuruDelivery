import React, {useEffect, useState} from 'react';
import NavBar from "../../components/NavBar";
import HeaderCard from "../../components/HeaderCard";
import {changeQuantityCarrinho, deleteFromCarrinho, getCarrinho, getEmpresa, postPedido} from "../../api/empresa";
import {useNavigate, useParams} from "react-router-dom";
import CartItem from "../../components/CartItem";
import {getEnderecos, postEndereco} from "../../api/user";
import { Field, Form, Formik } from 'formik';
import InputText from '../../components/InputText';
import LargeButton from '../../components/LargeButton';

function CartPage() {

    const [empresa, setEmpresa] = useState({})
    const [carrinho, setCarrinho] = useState([]);
    const [enderecos, setEnderecos] = useState([]);
    const [selectedEndereco, setSelectedEndereco] = useState(1);
    const [totalPedido, setTotalPedido] = useState(0.00);
    const {empresaId} = useParams()
    const navigate = useNavigate()
    const [hiddenEnd, setHiddenEnd] = useState(true)

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


    async function loadEnderecos(){
        const list = await getEnderecos()
        setEnderecos(list)
        console.dir(list)
    }

    //Carregar Endereços
    useEffect(()=>{
        loadEnderecos()
    },[])

    async function updateCart(){
        try {
            const carrinho = await getCarrinho(empresaId)
            setCarrinho(carrinho)
            const total = carrinho.reduce((acc, value)=>acc+value.preco, 0)
            setTotalPedido(total)
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

    const initialEndereco ={
        cep: "", 
        cidade: "", 
        bairro: "",
        rua: "",
        numero: "",
        complemento: ""
    }
    
    async function adicionarEndereco(values, {resetForm}){
        const endereco = {
                "cep": values.cep,
                "cidade": values.cidade,
                "bairro": values.bairro,
                "rua": values.rua,
                "numero": values.numero,
                "complemento": values.complemento
        }
        try{
            const data = await postEndereco(endereco)
            resetForm()
            loadEnderecos()
        }catch(error){
            console.error(error)
        }
    }


    async function handleQuantityChange(item, quant){
        if(item.quantidade > 1 || quant > 0 ){
            const data = await changeQuantityCarrinho(empresa.id, item.produto.id, item.quantidade+quant)
        }
        updateCart()
    }

    return (
        <>
            <NavBar shopCart={`${empresa.id}`}/>
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
                                total={"R$ "+item.preco.toFixed(2)}
                                onChangeQuantity={(quant) => handleQuantityChange(item, quant)}
                            />
                        </div>
                    ))}
                    <span className="self-end text-primary font-bold text-2xl">
                        {"R$ " + totalPedido.toFixed(2)}
                    </span>
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
                    <div>
                        <div className='flex flex-col w-10 h-7'>
                            <LargeButton text="+" action={() => setHiddenEnd(!hiddenEnd)} bg/>
                        </div>
                        <div hidden={hiddenEnd}>
                    <Formik
                        initialValues={initialEndereco}
                        onSubmit={adicionarEndereco}>
                        {()=>(
                        <Form className='flex flex-col' >
                            <Field as={InputText} name="cep" type="text" placeholder="Digite o CEP"/>
                            <Field as={InputText} name="cidade" type="text" placeholder="Cidade:"/>
                            <Field as={InputText} name="bairro" type="text" placeholder="Bairro:"/>
                            <Field as={InputText} name="rua" type="text" placeholder="Rua:"/>
                            <Field as={InputText} name="numero" type="text" placeholder="Número:"/>
                            <Field as={InputText} name="complemento" type="text" placeholder="Complemento:"/>
                            <LargeButton text="Adicionar endereço" bg/>
                        </Form>
                        )}
                    </Formik>
                    </div>
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