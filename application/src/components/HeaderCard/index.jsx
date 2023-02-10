import React from 'react'

export default function HeaderCard({nome, email, telefone, foto}) {
    return (
        <>
            <a href="#" className="flex flex-col items-center bg-surface border border-gray-200 rounded-lg
        shadow md:flex-row w-full hover:bg-gray-100 text-on-surface
         dark:border-gray-700 dark:bg-gray-800 dark:hover:bg-gray-700">
                <img className="object-cover w-full rounded-t-lg h-96 md:h-auto md:w-48 md:rounded-none md:rounded-l-lg"
                     src={foto} alt="Logo"/>
                <div className="flex flex-col justify-between p-4 leading-normal">
                    <h5 className="mb-2 text-2xl font-bold tracking-tights dark:text-white">{nome}</h5>
                    <p className="mb-3 font-normal ">email: {email}</p>
                    <p className="mb-3 font-normal ">telefone: {telefone}</p>
                </div>
            </a>
        </>
    )
}