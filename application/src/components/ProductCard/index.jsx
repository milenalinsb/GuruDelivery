import React, { useState } from 'react'
import Counter from '../Counter'
import Separator from '../Separator'

export default function ProductCard({foto, nome, preco, descricao}) {

    const [counter, setCounter] = useState(0)

    return (
        <div className="max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
            <a href="#">
                <img className="rounded-t-lg" src={foto} alt="" />
            </a>
            <div className="p-5">
                <a href="#">
                    <h5 className="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
                        {nome}
                    </h5>
                </a>
                <p className="mb-3 font-normal text-gray-700 dark:text-gray-400">
                    {descricao}
                </p>
                <p className='text-primary font-bold'>R$ {preco}</p>
                <div className='flex gap-2'>
                    <Counter value={counter} onChange={setCounter}/>
                    <button
                        className='text-on-primary bg-primary rounded-md px-2'
                    >
                        Adicionar
                    </button>
                </div>

            </div>
        </div>
    )
}
