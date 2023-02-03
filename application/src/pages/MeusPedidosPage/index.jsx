import React from 'react';
import NavBar from "../../components/NavBar";
import CartItem from "../../components/CartItem";
import PedidoCard from "../../components/PedidoCard";

function MeusPedidosPage() {
    return (
        <div className="">
            <NavBar/>
            <div className="bg-background h-screen p-2">
                <main>
                    <PedidoCard/>
                    <PedidoCard/>
                </main>
            </div>
        </div>
    );
}

export default MeusPedidosPage;