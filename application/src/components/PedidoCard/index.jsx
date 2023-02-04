import React, {useState} from 'react';
import CartItem from "../CartItem";

function PedidoCard({pedido}) {

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
                        src={pedido.empresa.fotoPerfil} alt="Logo"/>
                    <span>{pedido.empresa.nome}</span>
                    <span>{`${pedido.endereco.rua}, ${pedido.endereco.numero}`}</span>
                    <span>{pedido.status}</span>
                    <span>R$ {pedido.total.toFixed(2)}</span>
                    <span>{arrow}</span>
                </div>
                </a>
                <div className="w-5/6 self-center" hidden={hidden}>
                    {pedido.produtosPedido.map(cart => (
                        <CartItem
                            foto={cart.produto.foto}
                            nome={cart.produto.nome}
                            quantidade={cart.quantidade}
                            total={'R$ ' + (cart.quantidade * cart.produto.preco).toFixed(2)}
                        />

                    ))}
                </div>
            </div>
        </>
    );
}

export default PedidoCard;