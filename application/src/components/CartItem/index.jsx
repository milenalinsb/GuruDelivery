import React from 'react';


function CartItem({foto, nome, quantidade, onAction}) {
    return (
        <>
            <div className="flex items-center bg-surface border border-gray-200 rounded-lg
        shadow md:flex-row w-full hover:bg-gray-100 text-on-surface
         dark:border-gray-700 dark:bg-gray-800 dark:hover:bg-gray-700 justify-between">
                <img className="object-cover w-full rounded-t-lg w-48 md:rounded-none md:rounded-l-lg"
                     src={foto} alt="Logo"/>
                <div className="flex flex-col justify-between p-4 leading-normal">
                    <h5 className="mb-2 text-lg font-bold tracking-tights dark:text-white">{nome}</h5>
                    <p className="mb-3 font-normal "></p>
                </div>
                <div className="flex flex-col items-center p-4 leading-normal">
                    <h5 className="mb-2 text-lg font-bold tracking-tights dark:text-white">quant</h5>
                    <p className="mb-3 font-normal "></p>
                    <p className="mb-3 font-normal ">{quantidade}</p>
                </div>
                <div>
                    <button className="bg-primary p-2 rounded mr-3 text-on-primary"
                        onClick={onAction}
                    >Remover</button>
                </div>
            </div>
        </>
    );
}

export default CartItem;