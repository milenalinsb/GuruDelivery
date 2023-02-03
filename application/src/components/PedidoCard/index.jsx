import React, {useState} from 'react';
import CartItem from "../CartItem";

function PedidoCard(props) {

    const [hidden, setHidden] = useState(true);
    const [arrow, setArrow] = useState(">");

    function handleHide(){
        setHidden(!hidden)
        if(arrow === ">"){
            setArrow("v")
        }else{
            setArrow(">")
        }
    }

    return (
        <>
            <div className="flex flex-col">
                <a className="cursor-pointer" onClick={handleHide}>
                <div className="flex gap-2 items-center justify-between bg-surface shadow rounded-lg overflow-hidden">
                    <img className="w-36"
                        src="https://diariodorio.com/wp-content/uploads/2020/07/daleopizzaria_20200710_144435_0.jpg" alt="Logo"/>
                    <span>Empresa</span>
                    <span>Endereco</span>
                    <span>Status</span>
                    <span>Total</span>
                    <span>{arrow}</span>
                </div>
                </a>
                <div className="w-5/6 self-center" hidden={hidden}>
                    <CartItem/>
                    <CartItem/>
                    <CartItem/>
                    <CartItem/>
                    <CartItem/>
                </div>
            </div>
        </>
    );
}

export default PedidoCard;