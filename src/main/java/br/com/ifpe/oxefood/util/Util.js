// src/views/util/Util.js
import { toast } from 'react-toastify';

export function notifySuccess(mensagem) {
  toast.success(mensagem, {
    position: "top-right",
    autoClose: 3000,
    theme: "colored"
  });
}

export function notifyError(mensagem) {
  toast.error(mensagem, {
    position: "top-right",
    autoClose: 3000,
    theme: "colored"
  });
}
