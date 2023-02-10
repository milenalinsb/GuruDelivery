import React, {useEffect, useState} from 'react';
import NavBar from "../../components/NavBar";
import CartItem from "../../components/CartItem";
import PedidoCard from "../../components/PedidoCard";
import {getUserPedidos} from "../../api/user";
import {useNavigate} from "react-router-dom";

function MeusPedidosPage() {

    const [pedidos, setPedidos] = useState([]);
    const navigate = useNavigate()

    async function loadPedido(){
        try{
            const values = await getUserPedidos()
            setPedidos(values)
            console.dir(values)
        }catch (err){
            if(err.response.status === 401){
                navigate("/login")
            }
        }
    }

    useEffect(() => {
        loadPedido()
    }, []);


    return (
        <div className="">
            <NavBar/>
            <div className="bg-background h-screen p-2">
                <main>
                    {pedidos.map( pedido => (
                        <PedidoCard pedido={pedido}/>
                    ))}
                </main>
            </div>
        </div>
    );
}

export default MeusPedidosPage;