/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "users".
 */
public final class DbxUserUsersRequests {
    // namespace users

    private final DbxRawClientV2 client;

    public DbxUserUsersRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route users/get_account
    //

    /**
     * Get information about a user's account.
     *
     *
     * @return Basic information about any account.
     */
    BasicAccount getAccount(GetAccountArg getAccountArg) throws GetAccountErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/users/get_account",
                                   getAccountArg,
                                   false,
                                   GetAccountArg.Serializer.INSTANCE,
                                   BasicAccount.Serializer.INSTANCE,
                                   GetAccountError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetAccountErrorException(ex.getRequestId(), ex.getUserMessage(), (GetAccountError) ex.getErrorValue());
        }
    }

    /**
     * Get information about a user's account.
     *
     * @param accountId  A user's account identifier. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     *
     * @return Basic information about any account.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public BasicAccount getAccount(String accountId) throws GetAccountErrorException, DbxException {
        GetAccountArg arg = new GetAccountArg(accountId);
        return getAccount(arg);
    }

    //
    // route users/get_account_batch
    //

    /**
     * Get information about multiple user accounts.  At most 300 accounts may
     * be queried per request.
     *
     */
    List<BasicAccount> getAccountBatch(GetAccountBatchArg getAccountBatchArg) throws GetAccountBatchErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/users/get_account_batch",
                                   getAccountBatchArg,
                                   false,
                                   GetAccountBatchArg.Serializer.INSTANCE,
                                   com.dropbox.core.stone.StoneSerializers.list(BasicAccount.Serializer.INSTANCE),
                                   GetAccountBatchError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetAccountBatchErrorException(ex.getRequestId(), ex.getUserMessage(), (GetAccountBatchError) ex.getErrorValue());
        }
    }

    /**
     * Get information about multiple user accounts.  At most 300 accounts may
     * be queried per request.
     *
     * @param accountIds  List of user account identifiers.  Should not contain
     *     any duplicate account IDs. Must contain at least 1 items, not contain
     *     a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<BasicAccount> getAccountBatch(List<String> accountIds) throws GetAccountBatchErrorException, DbxException {
        GetAccountBatchArg arg = new GetAccountBatchArg(accountIds);
        return getAccountBatch(arg);
    }

    //
    // route users/get_current_account
    //

    /**
     * Get information about the current user's account.
     *
     * @return Detailed information about the current user's account.
     */
    public FullAccount getCurrentAccount() throws DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/users/get_current_account",
                                   null,
                                   false,
                                   com.dropbox.core.stone.StoneSerializers.void_(),
                                   FullAccount.Serializer.INSTANCE,
                                   com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"get_current_account\":" + ex.getErrorValue());
        }
    }

    //
    // route users/get_space_usage
    //

    /**
     * Get the space usage information for the current user's account.
     *
     * @return Information about a user's space usage and quota.
     */
    public SpaceUsage getSpaceUsage() throws DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/users/get_space_usage",
                                   null,
                                   false,
                                   com.dropbox.core.stone.StoneSerializers.void_(),
                                   SpaceUsage.Serializer.INSTANCE,
                                   com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"get_space_usage\":" + ex.getErrorValue());
        }
    }
}
